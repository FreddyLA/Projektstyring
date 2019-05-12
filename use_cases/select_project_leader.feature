Feature: Choosing a project leader
	Description: A project leader is chosen for a project
	Actors: A development worker

Scenario: Assign project leader
Given a project with the name "Project 1" exists
And the project doesn't have a project leader
When a developement worker is assigned to be the project leader
Then the project leader of the project is the development worker

Scenario: Assign new project leader
Given a project with the name "Project 1" exists
And a project leader has been selected
When the project leader assigns a development worker to be project leader
Then the selected development worker is made leader of the project

Scenario: Development worker assigns project leader for a project they are not the leader of
Given a project with the name "Project 1" exists
And a project leader has been selected
And a development worker is not the leader of the project
When the development worker assigns a development worker to be project leader
Then an error message "Action for project leader only" is presented