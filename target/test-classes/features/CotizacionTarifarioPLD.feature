Feature: Pricing PLD Tarifario

  Scenario: 1- Executive can price a PLD product in its own autonomy.

    Given a user visits pricingminoristaPage
    When the user selects product "PTMO. LIBRE DISPONIBILIDAD" and modality "REENGANCHE"
    Then The Page says "Se guardó la operación con éxito."



