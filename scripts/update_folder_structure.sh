#! /bin/bash

TOPDIR=$(git rev-parse --show-toplevel)

INDEX=1001

shopt -s nullglob

while [ ${INDEX} -lt 4999 ]; do
  START=$(printf "%04d" "${INDEX}")
  END=$(printf "%04d" "$((INDEX + 9))")

  START2=${START:0:2}01
  END2=$(printf "%04d" "$((START2 + 99))")

  START3=${START:0:1}001
  END3=$(printf "%04d" "$((START3 + 999))")

  TARGET="${TOPDIR}/leetcode/${START3}-${END3}/${START2}-${END2}/${START}-${END}"

  if [ -d ${TARGET} ]; then
    INDEX=$((INDEX + 10))
    continue
  fi

  SOURCES=(${TOPDIR}/leetcode/${START3}-${END3}/${START2}-${END2}/${START:0:3}*)

  if [[ -n "${SOURCES[0]}" ]]; then
    mkdir -p ${TARGET}
    mv "${SOURCES[@]}" ${TARGET}
  fi

  #
  # next round
  INDEX=$((INDEX + 10))
done
