#!/bin/bash

rm -f NONCOMPLIANT.txt
rm -f COMPLIANT.txt

DIR="${1:-.}"

FAILS=0

EXT_RUBY="https://rubygems.org/"
EXT_NODE="https://registry.npmjs.org/"
EXT_MAVEN="http://repo1.maven.org/maven2"

## Ruby Check
while read -r file
do
    if grep -q "$EXT_RUBY" "$file"; then
      echo "$EXT_RUBY in $file";
      FAILS=1;
    fi
done < <(find $DIR -name "Gemfile.lock")

## npm Check
while read -r file
do
    if grep -q "$EXT_NODE" "$file"; then
      echo "$EXT_NODE in $file";
      FAILS=1;
    fi
done < <(find $DIR -name "package-lock.json")

## maven Check
while read -r file
do
    if grep -q "$EXT_MAVEN" "$file"; then
      echo "$EXT_MAVEN in $file";
      FAILS=1;
    fi
done < <(find $DIR -name "pom.xml")

if [ $FAILS -eq 1 ]; then
  echo -e "\nThis repo has files that are not in compliance";
  touch NONCOMPLIANT.txt
  exit 1;
else
  echo "This repo is in compliance"
  touch COMPLIANT.txt
fi
