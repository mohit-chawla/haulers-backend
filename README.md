# haulers-backend [![CircleCI](https://circleci.com/gh/mohit-chawla/haulers-backend.svg?style=svg)](https://circleci.com/gh/mohit-chawla/haulers-backend)
Backend for haulers app

## Project Features
### Backend
	- Self generating API documentation
	- Developers get email alerts on exceptions
	- User login and Session Management using Spring Security
	- Redis based faster session management
	- Location based search support
	- Unit Tests using JUnit

### Devops
	- Continuous Integration using Circle CI
	- Automatic Deployments on heroku if build success and tests pass
	- Health Checks and trace using Spring Actuator

### Logging
	- Tomcat Access Logs (with authentication headers) in target/tomcat-logs

## Prerequisites :
   - Install and run [mongodb]
   - Install and run [redis]
   - set environment variables:
      - HAULERS_EMAIL [gmail user from which project developers receive alerts]
      - HAULERS_PASS [gmail password for above account]
      - MONGODB_URI [Uri for Mongodb connection]
      - REDIS_URL [Url for Redis-server]
      - AWS_BUCKET [AWS Bucket to upload images]
      - AWS_ACCESS [Access Key for AWS Bucket]
      - AWS_SECRET [Secret Key for AWS Bucket]

## API Resources

### GET
  - [GET /customer](#get-test)
  - [GET /customer/all](#get-test)
  - [GET /customer/signup]
  - [GET /customer/update/loc]
  - [GET /customer/images]
  - [GET /driver](#get-test)
  - [GET /driver/all](#get-test)
  - [GET /driver/signup]
  - [GET /driver/update/loc]
  - [GET /driver/images]
  - [GET /job]
  - [GET /job/all]
  - [GET /job/customer]
  - [GET /job/driver]
  - [GET /job/driver/respond]


### POST
  - [POST /customer](#get-test)
  - [POST /driver](#get-test)
  - [POST /job](#get-test)
  - [POST /customer/images]
  - [POST /driver/images]

### GET /customer

Example: http://www.mohitchawla.in

Response body:

    {
        "response": "something"
    }


## Support :
  
  - This code is maintained by [Kripa], [Kriti] and [Mohit].
  
  
## License :
  
  The code is available at github [project][home] under [MIT license][4].
  
   [Mohit]: http://www.mohitchawla.in
   [Kriti]: http://www.kritisingh.in
   [Kripa]: https://github.com/coderKr
   [project]: https://github.com/mohit-chawla/haulers-backend
   [4]: http://revolunet.mit-license.org
   [mongodb]: https://www.mongodb.com
   [redis]: https://redis.io