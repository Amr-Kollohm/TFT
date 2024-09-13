# TFT
This repository is made to optimize the active trait count in Team Fight Tactics (TFT). While it was created with set 12 in mind, it should generally work for any TFT set.
## Motivation
***So why would you want to **maximize** active trait count?***

Other than the obvious fact that active traits buff and make your team **stronger**, maximizing active trait count can guide plans for all early, mid, and late-game stages of a TFT game. It has the added bonus of discovering comps in PBE or the early stages of a TFT set.
However, the main inspiration for this project was the augment **Stand United II** and this bad boy:

![TahmKench](https://github.com/user-attachments/assets/5d00be48-b036-48aa-927e-a205c973d88d)

The Arcana trait (*If applied to Tahm Kench*) will give a **team wide** HP buff to all your units.

>**Note**: Both Stand United II and Arcana on Tahm Kench *ONLY* count non-unique active traits that's why for example Bat Queen or Ascendant will not be taken into account.

## What can the current version do?
Given a team size ***n*** the code will output the names of *ALL* combinations of ***n*** units that will maximize the active trait count.


## How does it work?
The codes iterates through **EVERY** possible combination of ***n*** units, calculates the number of active traits for each specific combination, compares combinations with each other and saves the combinations that maximize the number of active traits. This is **Brute Forcing** which **will work** but is not very *efficient* or *fast*.

## Technical Stuff
The current version of the code runs in **O(kCn)** where k is the total number of units and n is the number   

## Results
