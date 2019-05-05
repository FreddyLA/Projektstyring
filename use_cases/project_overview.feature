Feature: Overview of a project
Description: The projectleader views the statistics of each activity of a project and of total project
Actor: Project leader

Background: A project and an activity exists
Given a project with the name "Project 1" exists
And a project leader has been selected
And the project leader creates a new activity with the name "Activity"
And the project leader creates a new activity with the name "Activity2"

Scenario: Project leader views project overview
Given the activities of the project has registrered workhours from assigned development workers
And a development worker is the leader of the project
When the development worker accesses an overview of the project development
Then an overview of the project development is presented

Scenario: A development worker attempts to view project overview
Given the activities of the project has registrered workhours from assigned development workers
And a development worker is not the leader of the project
When the development worker accesses an overview of the project development
Then an error message "Only project leaders can see an overview of the project development" is presented