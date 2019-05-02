Feature: Generere en rapport over et projekt
Beskrivelse: Projektleder genererer en projektudviklings rapport
Aktoer: Projektleder

Scenario: Projektleder genererer en projektudviklings rapport ud fra projektet som projektlederen er projektleder i
Given a project has been created
And the project has been worked on
And the project leader generates a project development rapport of the project of which the project leader is the project leader of
Then the generated development rapport is generated

Scenario: Projektleder proever at generere en projektudviklings rapport ud fra projektet som projektlederen ikke er projektleder i
Given a project has been created
And the project has been worked on
And the project leader generates a project development rapport of the project of which the project leader is not the project leader of
Then an error message "Only the project leader of the project can generate a development rapport of the project"

Scenario: Udviklingsmedarbejder proever at generere en projektudviklings rapport
Given a project has been created
And the project has been worked on
And a development worker generates a project development rapport of a project
Then an error message "Only the project leader of the project can generate a development rapport of the project"