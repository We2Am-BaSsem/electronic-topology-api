#!/bin/bash

export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64/
rm -r allure-results/
mvn clean test
allure generate allure-results --clean
allure open