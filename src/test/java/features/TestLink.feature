Feature: Test link

  @all
  Scenario: Test link
    When user launch browser
    Then user go to "http://blog.csssr.ru/qa-engineer/"
    Then user click link "НАХОДИТЬ НЕСОВЕРШЕНСТВА"
    Then user click link "Софт для быстрого создания скриншотов"
    Then check current link "http://monosnap.com/"