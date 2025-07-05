
# BDD Framework Java

A comprehensive Behavior-Driven Development (BDD) framework built with Selenium WebDriver and Cucumber for testing multiple web applications.

## 🚀 Features

- **Multi-Application Support**: Test TodoMVC, Calculator, and practice applications
- **BDD with Cucumber**: Gherkin syntax for readable test scenarios
- **Page Object Model**: Organized engine classes for each application
- **Beautiful Reporting**: HTML reports with screenshots
- **Cross-Browser Testing**: Chrome, Safari, Firefox support
- **Java 21 Compatible**: Modern Java features
- **Mac M4 Optimized**: Apple Silicon support
- **Maven Build**: Standard build tool integration

## 🏗️ Framework Structure

```
src/
├── main/java/com/automation/
│   ├── core/           # Framework core components
│   ├── engines/        # Application-specific business logic  
│   ├── models/         # Data models
│   └── utils/          # Utility classes
└── test/
    ├── java/com/automation/
    │   ├── stepdefinitions/  # Cucumber step definitions
    │   ├── hooks/           # Test lifecycle management
    │   └── runners/         # Test execution runners
    └── resources/features/   # Gherkin feature files
```

## 🛠️ Technologies Used

- **Java 21**: Programming language
- **Selenium WebDriver 4.16+**: Browser automation
- **Cucumber 7.14**: BDD framework
- **JUnit 4**: Test runner
- **Maven**: Build and dependency management
- **WebDriverManager**: Automatic driver management

## 🚦 Quick Start

### Prerequisites
- Java 21 installed
- Maven 3.6+ installed
- Chrome browser installed

### Installation
```bash
git clone https://github.com/YOUR_USERNAME/bdd-framework-java.git
cd bdd-framework-java
mvn clean install
```

### Run Tests
```bash
# Run all tests
mvn test

# Run specific application
mvn test -Dtest=TodoRunner
mvn test -Dtest=CalculatorRunner

# Run smoke tests only
mvn test -Dtest=SmokeTestRunner

# Generate reports
mvn test verify
```

## 📊 Test Reports

After running tests, view reports:
```bash
# Basic reports
open target/cucumber-reports/index.html

# Advanced reports  
open target/cucumber-html-reports/overview-features.html
```

## 🎯 Supported Applications

### TodoMVC Application
- Add tasks
- Complete tasks
- Task validation
- List management

### Calculator Application
- Basic arithmetic operations
- Step-by-step calculations
- Result validation

## 🏷️ Test Execution by Tags

```bash
# Smoke tests (quick validation)
mvn test -Dcucumber.filter.tags="@smoke"

# Regression tests (comprehensive)
mvn test -Dcucumber.filter.tags="@regression"

# Specific application
mvn test -Dcucumber.filter.tags="@todo"
mvn test -Dcucumber.filter.tags="@calculator"
```

## 🔧 Configuration

### Browser Selection
```bash
# Run with Chrome (default)
mvn test

# Run with Safari  
mvn test -Dbrowser=safari

# Run with Firefox
mvn test -Dbrowser=firefox
```

## 📈 Framework Benefits

- **Maintainable**: Clear separation of concerns
- **Scalable**: Easy to add new applications
- **Readable**: Business-friendly Gherkin scenarios
- **Reliable**: Robust wait strategies and error handling
- **Professional**: Enterprise-grade reporting and structure

## 🤝 Contributing

1. Fork the repository
2. Create feature branch (`git checkout -b feature/amazing-feature`)
3. Commit changes (`git commit -m 'Add amazing feature'`)
4. Push to branch (`git push origin feature/amazing-feature`)
5. Open Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👨‍💻 Author

**Jerome** - Automation Test Engineer
- Specialized in BDD frameworks java for automation testing
- Java 21 and Selenium WebDriver expertise
- Focus on maintainable and scalable test automation

## 🙏 Acknowledgments

- Cucumber team for the excellent BDD framework
- Selenium WebDriver contributors
- TodoMVC project for practice application
- Calculator.net for mathematical testing scenarios