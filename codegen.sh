java -jar swagger-codegen-cli.jar generate -i https://euretos-brain.com/spine-ws/v2/api-docs/auth -l java  -c config.json
token=`gettoken.sh $1 $2`

# correct output from swagger for occurrences of newlines in documentation
curl -s --header 'Content-Type: application/json' --header 'Accept: application/json' --header 'x-token: '$token https://euretos-brain.com/spine-ws/v2/api-docs/external | sed -e 's/\\n//g' | sed -e 's/\/\*//g' | sed -e 's/\*\///g' > external.json 
java -jar swagger-codegen-cli.jar generate -i external.json -l java -c config.json  
#rm external.json
