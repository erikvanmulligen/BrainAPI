token=`gettoken.sh $1 $2`
curl --header 'Content-Type: application/json' --header 'Accept: application/json' --header 'x-token: bXVsbGlnZW5AZ21haWwuY29tU3VuIE1heSAyMiAxNTozNTozNiBDRVNUIDIwMTY1YzQ0N2QwNC0xYjIyLTQyM2MtYTYzMS1iZTlkNDMzNGQxNGE=' https://euretos-brain.com/spine-ws/v2/api-docs/external
