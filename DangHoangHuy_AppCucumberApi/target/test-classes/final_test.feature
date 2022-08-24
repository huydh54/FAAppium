Feature: Final test end to end feature

  Scenario Outline: Verify that the user is able to add a macro
    Given I open application
    When I tap on click Macro on Dashboard Page
    And I add a Trigger
    Then I will see the Trigger Macro show correct added values
    When I navigate to Action Page from Macro Page
    And I add an Action
    Then I will see the Action Macro show correct added values
    When I add an Constrain
    Then I will see the Contrains show correct added values
    When I create new Local Variable with name "<VariableName>", and input value "<VariableValue>"
    Then I will see the Local Varialbe show correct added values "<VariableValue>"

    Examples:
      |VariableName |VariableValue|
      |Test Case    |1            |
      |Dang Huy     |3            |
      |Example      |9            |

  Scenario Outline: Verify that the user is able to add an action blocks
    Given I open application
    When I navigate to Action Block Detail Page and enter name "<ActionBlockName>" and description "<ActionBlockDescription>"
    And I add new input variable with name "<InputVariableName>", type "<InputVariableType>" and value "<InputVariableValue>"
    When I tap on Action to add an action on Action Blocks Detail Page
    And I add an Action
    And I add new output variable with name "<OutputVariableName>", type "<OutputVariableType>" and value "<OutputVariableValue>"
    Then I will see the input variable "<InputVariableName>":"<InputVariableValue>", action, output variable "<OutputVariableName>":"<OutputVariableValue>" should show correctly information
    When I tap on V button to add the action block
    Then I will see action Block should be added and the block name "<ActionBlockName>" and description "<ActionBlockDescription>" should show correctly

    Examples:
      |ActionBlockName |ActionBlockDescription|InputVariableName|InputVariableType|InputVariableValue|OutputVariableName|OutputVariableType|OutputVariableValue     |
      |Action Block A  |This is First Block   |ABC input        |Boolean          |True              |XYZ output        |String            |This is a testing string|
      |Action Block B  |This is Second Block  |DEF input        |Boolean          |False             |IKLM output       |String            |Welcom to Cucumber      |
      |Action Block C  |This is Third Block   |OGH input        |String           |Hello Word        |NMO output        |Boolean           |True                    |