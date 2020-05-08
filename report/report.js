$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/searching.feature");
formatter.feature({
  "name": "Searching at empik.com",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "Searching for books using searching bar at main page",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "User is on home page",
  "keyword": "Given "
});
formatter.step({
  "name": "User enter book \u003ctitle\u003e in searching bar",
  "keyword": "When "
});
formatter.step({
  "name": "User choose book category",
  "keyword": "And "
});
formatter.step({
  "name": "User click search button",
  "keyword": "And "
});
formatter.step({
  "name": "Results should be books",
  "keyword": "Then "
});
formatter.step({
  "name": "Results should contains entered phrase",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "title"
      ]
    },
    {
      "cells": [
        "krzyżacy"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Searching for books using searching bar at main page",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "User is on home page",
  "keyword": "Given "
});
formatter.match({
  "location": "SearchingSteps.userIsOnHomePage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enter book krzyżacy in searching bar",
  "keyword": "When "
});
formatter.match({
  "location": "SearchingSteps.userEnterBookTitleInSearchingBar(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User choose book category",
  "keyword": "And "
});
formatter.match({
  "location": "SearchingSteps.userChooseBookCategory()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User click search button",
  "keyword": "And "
});
formatter.match({
  "location": "SearchingSteps.userClickSearchButton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Results should be books",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchingSteps.resultsShouldBeBooks()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Results should contains entered phrase",
  "keyword": "And "
});
formatter.match({
  "location": "SearchingSteps.resultsShouldContainsEnteredPhrase()"
});
formatter.result({
  "status": "passed"
});
});