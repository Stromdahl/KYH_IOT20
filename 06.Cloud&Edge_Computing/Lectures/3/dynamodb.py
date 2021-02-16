import boto3
import json

access_key = "ojlnvyxg0zsamDRialjdbpr0SlTtstKX3CaV36++"
access_id = "AKIAYVW5WG46DAH3HHNL"


def get_resource():
    dynamodb = boto3.resource('dynamodb',
                                aws_access_key_id = access_id,
                                aws_secret_access_key = access_key,
                                region_name="eu-north-1")
    return dynamodb


def create_user_table(dynamodb=None):
    if not dynamodb:
        dynamodb = get_resource()

    table = dynamodb.create_table(
        TableName='Users',
        KeySchema=[
            {
                "AttributeName": "userid",
                "KeyType": "HASH" # Partition key
            },
            {
                "AttributeName": "username",
                "KeyType": "RANGE" # Sort key
            }
        ],
        AttributeDefinitions = [
            {
                "AttributeName": "userid",
                "AttributeType": "N"
            },
            {
                "AttributeName": "username",
                "AttributeType": "S"
            }
        ],
        ProvisionedThroughput = {
            'ReadCapacityUnits': 10,
            'WriteCapacityUnits': 10
        }
    )
    return table


def store_users(users, dynamodb=None):
    if not dynamodb:
        dynamodb = get_resource()

    table = dynamodb.Table('Users')
    for user in users:
        print(f"Adding user {user['username']}")
        table.put_item(Item=user)


def main():
    with open("users.json", "r", encoding='utf-8') as json_file:
        users = json.load(json_file)
    
    store_users(users)


if __name__ == "__main__":
    main()