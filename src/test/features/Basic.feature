Feature: Test something anything

  Scenario Outline: Test Something please
    Given test "<username>" with multiple fields "<password>"
    When  hit login button
    Then verify home page

    Examples:
            |username|password|
            |abc|pong|