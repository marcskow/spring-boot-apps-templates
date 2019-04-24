# spring-bootstrap-maven-heroku

With sources uploaded to remote heroku:
```
heroku login

git init
git add .
git commit -m "initial commit"

heroku create
heroku create <APP_NAME>
heroku apps:rename --app <OLD_NAME> <NEW_NAME>

git push heroku master

heroku open
heroku logs --tail
```

Using Heroku Maven Plugin:
```
heroku create <APP_NAME_FROM_POM>

If Heroku CLI installed:
mvn clean heroku:deploy

Else set API_KEY:
HEROKU_API_KEY="SECRET"

mvn clean heroku:deploy
```