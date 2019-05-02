Feature: Oprettelse af aktivitet
	Beskrivelse: En projektleder opretter en aktivitet
	Aktoer: Projektleder
	
Scenario: Opret en aktivitet
Given a project has been created
And a project leader has been selected
And the project leader creates a new activity with the name "Activity"
Then a new activity with the name "Activity" is created

Scenario: Opret en aktivitet uden at vaere projektleder
Given a project has been created
And a development worker creates an activity for the project
Then an error message "Only project leaders can create activities" is presented

Scenario: Opret aktivitet med sluttidspunkt foer starttidspunkt
Given a project has been created
And a project leader has been selected
And the project leader creates a new activity with the name "Activity"
And the project leader assigns a start date
And the project leader assigns a deadline that is before the assigned start date
Then an error message "Deadline cannot be before the assigned start date"