SonarQube - Custom Rules for the module 'Informatik II'
=======

This projects contains all rules to evalute the programming tasks

If you are using SonarQube 8.9 LTS (latest release), use the following command to build it without any dependency to the current project status:

```
mvn clean install -f pom_SQ_8_9_LTS.xml
```

and if you want to run and test the rules, use this command:

```
mvn test -f pom_SQ_8_9_LTS.xml
```