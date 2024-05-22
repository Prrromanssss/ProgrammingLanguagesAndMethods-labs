#include <filesystem>
#include <fstream>
#include <iostream>
#include <set>
#include <string>
#include <algorithm>

namespace fs = std::filesystem;

std::set<std::string> extractHeaders(const std::string& filePath) {
    std::set<std::string> headers;
    std::ifstream file(filePath);
    std::string line;
    std::string header;
    bool isHeader = false;

    while (std::getline(file, line)) {
        if (line.find_first_not_of('=') == std::string::npos || line.find_first_not_of('-') == std::string::npos) {
            if (!header.empty()) {
                headers.insert(header);
                header.clear();
            }
            isHeader = true;
        } else if (isHeader) {
            header = line;
            isHeader = false;
        }
    }

    if (!header.empty()) {
        headers.insert(header);
    }

    return headers;
}

int main(int argc, char* argv[]) {
    if (argc < 2) {
        std::cerr << "Usage: " << argv[0] << " <directory_path>" << std::endl;
        return 1;
    }

    std::set<std::string> allHeaders;
    fs::path dirPath(argv[1]);

    if (!fs::exists(dirPath) || !fs::is_directory(dirPath)) {
        std::cerr << "Invalid directory path: " << dirPath << std::endl;
        return 1;
    }

    for (const auto& entry : fs::recursive_directory_iterator(dirPath)) {
        if (entry.is_regular_file() && entry.path().extension() == ".md") {
            std::set<std::string> headers = extractHeaders(entry.path().string());
            allHeaders.insert(headers.begin(), headers.end());
        }
    }

    std::ofstream output("headers.txt");
    for (const auto& header : allHeaders) {
        output << header << std::endl;
    }

    return 0;
}