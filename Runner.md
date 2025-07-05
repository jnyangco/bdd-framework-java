
# Command Line Run:

# run using tags
mvn test -Dcucumber.filter.tags="@calculator"
mvn test -Dcucumber.filter.tags="@calculator"

# run using tags - everything except (NOT)
mvn test -Dcucumber.filter.tags="@calculator"

# run with specific browser
mvn test -Dcucumber.filter.tags="@calculator" -Dbrowser=chrome


# TEST RUNNER FILE
mvn clean test -Dtest=TestRunner

# Check rerun file is created or not -> remove "clean" in mvn test (since rerun.txt will be deleted)
cat target/rerun.txt
mvn test -Dtest=FailedTestsRunner


# OPEN REPORT
open target/advanced-reports/cucumber-html-reports/overview-features.html




# =============================================================================
# =============================================================================
### Quick One-Liners:
```bash
# Run tests with advanced reporting and open dashboard
mvn clean test verify && open target/advanced-reports/cucumber-html-reports/overview-features.html


# Run tests and immediately open basic report
mvn clean test && open target/cucumber-reports/index.html


# Run smoke tests and view results
mvn test -Dtest=SmokeTestRunner && open target/smoke-reports/index.html
.
.
.
.






# =============================================================================
# =============================================================================


# =============================================================================
# COMPLETE COMMAND LINE OPTIONS FOR BDD FRAMEWORK
# =============================================================================

## BASIC EXECUTION COMMANDS

### Run all tests:
```bash
mvn test
mvn clean test
mvn clean test verify  # With advanced reports
```

### Clean and compile before testing:
```bash
mvn clean compile test
mvn clean install      # Compile, test, and package
```

# =============================================================================
# 1. RUNNING SPECIFIC TEST RUNNERS
# =============================================================================

### Run specific test runner classes:
```bash
# Todo application only
mvn test -Dtest=TodoRunner

# Calculator application only  
mvn test -Dtest=CalculatorRunner

# Smoke tests across all apps
mvn test -Dtest=SmokeTestRunner

# Regression tests
mvn test -Dtest=RegressionRunner

# All applications (master runner)
mvn test -Dtest=TestRunner

# Multiple runners at once
mvn test -Dtest="TodoRunner,CalculatorRunner"
mvn test -Dtest="SmokeTestRunner,RegressionRunner"
```

# =============================================================================
# 2. RUNNING BY CUCUMBER TAGS
# =============================================================================

### Single tag execution:
```bash
# Run only smoke tests
mvn test -Dcucumber.filter.tags="@smoke"

# Run only todo tests
mvn test -Dcucumber.filter.tags="@todo"

# Run only calculator tests
mvn test -Dcucumber.filter.tags="@calculator"

# Run only regression tests
mvn test -Dcucumber.filter.tags="@regression"
```

### Multiple tags (OR logic):
```bash
# Run smoke OR regression tests
mvn test -Dcucumber.filter.tags="@smoke or @regression"

# Run todo OR calculator tests
mvn test -Dcucumber.filter.tags="@todo or @calculator"

# Run any critical tests
mvn test -Dcucumber.filter.tags="@smoke or @critical or @sanity"
```

### Multiple tags (AND logic):
```bash
# Run tests that are both todo AND smoke
mvn test -Dcucumber.filter.tags="@todo and @smoke"

# Run tests that are both calculator AND regression
mvn test -Dcucumber.filter.tags="@calculator and @regression"
```

### Exclude tags (NOT logic):
```bash
# Run everything EXCEPT regression tests
mvn test -Dcucumber.filter.tags="not @regression"

# Run everything EXCEPT slow tests
mvn test -Dcucumber.filter.tags="not @slow"

# Run everything EXCEPT calculator tests
mvn test -Dcucumber.filter.tags="not @calculator"

# Complex exclusion
mvn test -Dcucumber.filter.tags="@smoke and not @slow"
```

# =============================================================================
# 3. RUNNING SPECIFIC FEATURE FILES
# =============================================================================

### Single feature file:
```bash
# Todo feature only
mvn test -Dcucumber.options="src/test/resources/features/todo.feature"

# Calculator feature only
mvn test -Dcucumber.options="src/test/resources/features/calculator.feature"

# Practice feature only
mvn test -Dcucumber.options="src/test/resources/features/practice.feature"
```

### Multiple feature files:
```bash
# Multiple specific features
mvn test -Dcucumber.options="src/test/resources/features/todo.feature src/test/resources/features/calculator.feature"
```

### Feature files with tags:
```bash
# Run specific feature with tag filtering
mvn test -Dcucumber.options="src/test/resources/features/todo.feature" -Dcucumber.filter.tags="@smoke"
```

# =============================================================================
# 4. BROWSER SELECTION
# =============================================================================

### Run with different browsers:
```bash
# Chrome (default)
mvn test
mvn test -Dbrowser=chrome

# Safari (Mac native)
mvn test -Dbrowser=safari

# Firefox
mvn test -Dbrowser=firefox

# Headless Chrome (faster)
mvn test -Dbrowser=chrome -Dheadless=true
```

### Cross-browser testing:
```bash
# Run same tests on different browsers
mvn test -Dbrowser=chrome -Dtest=SmokeTestRunner
mvn test -Dbrowser=safari -Dtest=SmokeTestRunner
mvn test -Dbrowser=firefox -Dtest=SmokeTestRunner
```

# =============================================================================
# 5. PARALLEL EXECUTION
# =============================================================================

### Parallel test execution:
```bash
# Run tests in parallel (3 threads)
mvn test -Dparallel=methods -DthreadCount=3

# Run test classes in parallel
mvn test -Dparallel=classes -DthreadCount=2

# Run with maximum parallelism
mvn test -Dparallel=all -DthreadCount=4
```

### Parallel with specific runners:
```bash
# Run multiple runners in parallel
mvn test -Dtest="TodoRunner,CalculatorRunner" -Dparallel=classes -DthreadCount=2
```

# =============================================================================
# 6. REPORTING OPTIONS
# =============================================================================

### Different report formats:
```bash
# Basic HTML reports
mvn test

# Advanced reports with verify phase
mvn test verify

# Generate reports without running tests (if already run)
mvn verify

# Clean reports and regenerate
mvn clean test verify
```

### Custom report locations:
```bash
# Specify custom report directory
mvn test -Dcucumber.plugin="html:custom-reports"
mvn test -Dcucumber.plugin="json:reports/results.json"
```

# =============================================================================
# 7. ENVIRONMENT CONFIGURATION
# =============================================================================

### Different environments:
```bash
# Local environment (default)
mvn test

# QA environment
mvn test -Denv=qa

# Staging environment  
mvn test -Denv=staging

# Production environment
mvn test -Denv=prod
```

### Custom base URLs:
```bash
# Override default URLs
mvn test -DtodoApp.url="https://custom-todo.com"
mvn test -DcalculatorApp.url="https://custom-calc.com"
```

# =============================================================================
# 8. DEBUG AND VERBOSE OPTIONS
# =============================================================================

### Debug execution:
```bash
# Verbose Maven output
mvn test -X

# Debug information
mvn test -Dmaven.surefire.debug

# Show all system properties
mvn test -Dmaven.test.skip=false -X
```

### Cucumber debug options:
```bash
# Verbose Cucumber output
mvn test -Dcucumber.options="--verbose"

# Dry run (check step definitions without execution)
mvn test -Dcucumber.options="--dry-run"

# Show step definition usage
mvn test -Dcucumber.options="--usage"
```

# =============================================================================
# 9. SKIP AND IGNORE OPTIONS
# =============================================================================

### Skip different phases:
```bash
# Skip tests entirely
mvn clean compile -DskipTests

# Skip test compilation but allow test execution
mvn test -Dmaven.test.skip.exec=false

# Continue on test failures
mvn test -Dmaven.test.failure.ignore=true
```

# =============================================================================
# 10. CUSTOM SYSTEM PROPERTIES
# =============================================================================

### Custom configuration:
```bash
# Set timeout values
mvn test -Dimplicit.wait=15 -Dexplicit.wait=30

# Set retry count for flaky tests
mvn test -Dretry.count=3

# Enable/disable screenshots
mvn test -Dscreenshots=false

# Set test data file
mvn test -Dtest.data.file="testdata/users.json"
```

# =============================================================================
# 11. MAVEN PROFILES (IF CONFIGURED)
# =============================================================================

### Using Maven profiles:
```bash
# Development profile
mvn test -Pdev

# QA profile
mvn test -Pqa

# Performance testing profile
mvn test -Pperformance

# Smoke testing profile
mvn test -Psmoke

# Full regression profile
mvn test -Pregression
```

# =============================================================================
# 12. COMBINATION COMMANDS (REAL-WORLD SCENARIOS)
# =============================================================================

### Daily development workflow:
```bash
# Morning: Quick smoke test
mvn clean test -Dtest=SmokeTestRunner -Dbrowser=chrome

# Development: Focus on specific app
mvn test -Dcucumber.filter.tags="@todo" -Dbrowser=safari

# Before commit: Regression with reports
mvn clean test verify -Dtest=RegressionRunner

# End of day: Full test suite
mvn clean test verify -Dparallel=classes -DthreadCount=2
```

### CI/CD pipeline scenarios:
```bash
# Build validation (fastest)
mvn clean test -Dcucumber.filter.tags="@smoke" -Dheadless=true

# Feature branch testing
mvn clean test -Dcucumber.filter.tags="@regression and not @slow"

# Release candidate testing
mvn clean test verify -Dparallel=methods -DthreadCount=3

# Production deployment validation
mvn test -Dcucumber.filter.tags="@smoke" -Denv=prod
```

### Cross-browser testing scenarios:
```bash
# Smoke tests across all browsers
mvn test -Dtest=SmokeTestRunner -Dbrowser=chrome
mvn test -Dtest=SmokeTestRunner -Dbrowser=safari  
mvn test -Dtest=SmokeTestRunner -Dbrowser=firefox

# One-liner for multiple browsers (using shell)
for browser in chrome safari firefox; do mvn test -Dtest=SmokeTestRunner -Dbrowser=$browser; done
```

### Debugging specific issues:
```bash
# Debug failing todo tests with verbose output
mvn test -Dcucumber.filter.tags="@todo" -X -Dcucumber.options="--verbose"

# Run single scenario for debugging
mvn test -Dcucumber.options="src/test/resources/features/todo.feature:5" # Line 5

# Debug with specific browser and no parallel execution
mvn test -Dtest=TodoRunner -Dbrowser=chrome -DthreadCount=1
```

# =============================================================================
# 13. REPORTING AND OUTPUT OPTIONS
# =============================================================================

### View results immediately:
```bash
# Run tests and open report (Mac)
mvn test verify && open target/cucumber-html-reports/overview-features.html

# Run with timestamp
mvn test -Dtimestamp=$(date +%Y%m%d_%H%M%S)

# Generate reports in specific format
mvn test -Dcucumber.plugin="pretty,html:reports/html,json:reports/json/results.json,junit:reports/junit/results.xml"
```

### Archive results:
```bash
# Create timestamped report directory
TIMESTAMP=$(date +%Y%m%d_%H%M%S)
mvn test verify
cp -r target/cucumber-html-reports "reports_$TIMESTAMP"
```

# =============================================================================
# 14. QUICK REFERENCE CHEAT SHEET
# =============================================================================

### Most commonly used commands:
```bash
# Quick smoke test
mvn test -Dtest=SmokeTestRunner

# Test specific app
mvn test -Dcucumber.filter.tags="@todo"

# Full regression with reports  
mvn clean test verify -Dtest=RegressionRunner

# Cross-browser smoke test
mvn test -Dtest=SmokeTestRunner -Dbrowser=safari

# Debug failing tests
mvn test -Dcucumber.filter.tags="@todo" -X

# Parallel execution
mvn test -Dparallel=classes -DthreadCount=2

# Generate reports only
mvn verify
```