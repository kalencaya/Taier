#!/usr/bin/env bash
echo 'taier Building...'

cd ../ && mvnw clean package -DskipTests -T 1C  -pl \
taier-ui,\
taier-data-develop \
-am