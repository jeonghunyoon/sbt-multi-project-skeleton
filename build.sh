#!/usr/bin/env bash

if [ $# -gt 0 ]; then
  PROJECT_NAME="${1}/"
fi

COMMAND="sbt ${PROJECT_NAME}clean ${PROJECT_NAME}assembly"

echo $COMMAND

eval $COMMAND