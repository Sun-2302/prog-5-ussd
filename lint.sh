#!/bin/bash

JAR=checkstyle.jar
URL=https://github.com/checkstyle/checkstyle/releases/download/checkstyle-10.12.3/checkstyle-10.12.3-all.jar

if [ ! -f "$JAR" ]; then
  echo "Téléchargement de $JAR..."
  curl -L "$URL" -o "$JAR"
fi

java -jar "$JAR" -c checkstyle.xml src/



