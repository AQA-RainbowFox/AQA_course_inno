#!/bin/bash

echo "Running tests with Maven..."
mvn clean test

echo "Generating Allure report..."
allure generate --clean

echo "Opening Allure report..."
allure open