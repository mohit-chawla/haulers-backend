# haulers-backend [![CircleCI](https://circleci.com/gh/mohit-chawla/haulers-backend.svg?style=svg)](https://circleci.com/gh/mohit-chawla/haulers-backend)
Backend for haulers app

## Project Features
   - Self generating API docs
   - Continuous integrations using Circle CI
   - Developer email alerts on exceptions
   - User login and Session Management
   - Redis based faster session management
   - Location based search support


## Prerequisites :
   - Install and run [mongodb]
   - Install and run [redis]
   - set ennvironment variables HAULERS_EMAIL and HAULERS_PASS with gmail username and password
   - Feature 2

## API Resources

  - [GET /customer](#get-test)
  - [POST /customer](#get-test)
  - [GET /driver](#get-test)
  - [POST /driver](#get-test)
  - [GET /job](#get-test)
  - [POST /job](#get-test)


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