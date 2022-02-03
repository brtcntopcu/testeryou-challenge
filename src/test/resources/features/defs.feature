Feature: IMDB info check
  Scenario: The Jazz Singer movie info check
    When I enter IMDB page
    When I click menu then click oscars
    When I choose 1929 year on event history
    When I click The Jazz Singer
    When I save movie director, writer and stars
    When I click IMDB button
    When I search "The Jazz Singer" on searchbar and choose
    Then I compare movie knowledge
    When I click photos
    Then I check broken images

  Scenario: The Circus movie info check
    When I enter IMDB page
    When I click menu then click oscars
    When I choose 1929 year on event history
    When I click The Circus
    When I save movie director, writer and stars
    When I click IMDB button
    When I search "The Circus" on searchbar and choose
    Then I compare movie knowledge
    When I click photos
    Then I check broken images