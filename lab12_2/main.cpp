#include <iostream>
#include <filesystem>
#include <fstream>
#include <regex>

namespace fs = std::filesystem;

// Функция для подсчета красных элементов в файле
int countRedElements(const std::string& filename) {
    std::ifstream file(filename);
    if (!file.is_open()) {
        std::cerr << "Error: Unable to open file " << filename << std::endl;
        return -1;
    }

    int redCount = 0;
    std::string line;
    std::regex colorPattern(R"(color=red)", std::regex_constants::icase);

    while (std::getline(file, line)) {
        if (std::regex_search(line, colorPattern)) {
            redCount++;
        }
    }

    return redCount;
}

int main(int argc, char* argv[]) {
    if (argc != 2) {
        std::cerr << "Usage: " << argv[0] << " <directory_path>\n";
        return 1;
    }

    fs::path directory(argv[1]);
    if (!fs::is_directory(directory)) {
        std::cerr << "Error: " << directory << " is not a directory.\n";
        return 1;
    }

    std::ofstream outFile("red.txt");
    if (!outFile) {
        std::cerr << "Error: Unable to open red.txt for writing.\n";
        return 1;
    }

    for (const auto& entry : fs::directory_iterator(directory)) {
        if (entry.is_regular_file() && entry.path().extension() == ".dot") {
            int redCount = countRedElements(entry.path().string());
            outFile << entry.path().filename().string() << ": " << redCount << '\n';
        }
    }

    std::cout << "Analysis complete. Results saved to red.txt.\n";
    return 0;
}
