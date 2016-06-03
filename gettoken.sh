#!/bin/bash
function jsonval {
    temp=`echo $json | sed 's/\\\\\//\//g' | sed 's/[{}]//g' | awk -v k="text" '{n=split($0,a,","); for (i=1; i<=n; i++) print a[i]}' | sed 's/\"\:\"/\|/g' | sed 's/[\,]/ /g' | sed 's/\"//g' | grep -w $prop`
    echo ${temp##*|}
}

if [ -z "$1" ]
  then
    echo "No argument supplied"
    exit
fi

json=`curl -s -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' --header 'x-token: bXVsbGlnZW5AZ21haWwuY29tU2F0IE1heSAyMSAxNDozOToxOSBDRVNUIDIwMTZkYmNlOGFjYS00Yzg1LTRhNTctOGVmNC1lODM3YzYxYjVjMTQ=' -d '{"username":"'$1'","password":"'$2'"}' 'https://euretos-brain.com/spine-ws/login/authenticate'`

prop='token'
echo `jsonval`

