$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("use_cases/test.feature");
formatter.feature({
  "name": "Cucumber test",
  "description": "\tDescription: Test that cucumber works\n\tActors: me",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Test",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "that cucumber works",
  "keyword": "Given "
});
formatter.match({
  "location": "CucumberTest.that_cucumber_works()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "cucumber works",
  "keyword": "Then "
});
formatter.match({
  "location": "CucumberTest.cucumber_works()"
});
formatter.result({
  "status": "passed"
});
});