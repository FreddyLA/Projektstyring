Feature: Overview of a project
Description: The projectleader views the statistics of each activity of a project and of total project
Actor: Project leader

Scenario: Project leader views project overview
Given a project has been created
And the project has activities
And the activities of the project has registrered workhours from assigned development workers
And the project leader access an overview of the project development
Then an overview of the project development is presented

Scenario: A development worker attempts to view project overview
Given a project has been created
And the project has activities
And the activities of the project has registrered workhours from assigned development workers
And a development worker access an overview of the project development
Then an error message "Only project leaders can see an overview of the project development"