#!/usr/bin/env bash

cnt=`grep -o '\[\d\{1,\}\](src/main/resources/\w\{1,\}.md)' README.md | wc -l`
sed -ig "s/累计总数: *[0-9]*$/累计总数: $cnt/" README.md