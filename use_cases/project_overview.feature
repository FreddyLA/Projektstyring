Feature: Overblik over et projekt
Description: Projektlederen kan se, hvordan timeforbruget udvikler sig per aktivitet og for hele projektet
Actor: Projektleder

Scenario: Projektleder tilgaar projekt overblik
Given a project has been created
And the project has activities
And the activities of the project has registrered workhours from assigned development workers
And the project leader access an overview of the project development
Then an overview of the project development is presented

Scenario: Udviklingsmedarbejder tilgaar projekt overblik
Given a project has been created
And the project has activities
And the activities of the project has registrered workhours from assigned development workers
And a development worker access an overview of the project development
Then an error message "Only project leaders can see an overview of the project development"