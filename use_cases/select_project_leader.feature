Feature: Choosing a project leader
	Description: A project leader is chosen for a project
	Actors: A development worker

Background:
Given a project with the name "Project 1" exists
And a project leader has been selected

Scenario: Assign new project leader
When the development worker assigns a development worker to be project leader
Then the selected development worker is made leader of the project

Scenario: Development worker assigns project leader for a project they are not the leader of
Given a development worker is not the leader of the project
When the development worker assigns a development worker to be project leader
Then an error message "Action for project leader only" is presented