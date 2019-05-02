Feature: Valg af projektleder
	Description: En projektleder vaelges til et projekt
	Actors: Udviklingsmedarbejder

Scenario: Choosing project leader
Given a project has been created
And the development worker that created the project assigns a development worker to be project leader
Then the selected development worker is made leader of the project

Scenario: Choosing projectleader for a project that already has a project leader
Given a project has been created
And a project leader has been selected
And the development worker that created the project assigns a development worker to be project leader
Then an error message "Project leader already assigned" is presented

Scenario: Choose a project leader, which is already a project leader
Given a project has been created
And the development worker that created the project assigns a development worker to be project leader
And the selected development worker already is a project leader for another project
Then an error message "Selected person already project leader for another project" is presented