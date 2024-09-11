# TFT
This repository is made to optimize the active trait count in Team Fight Tactics (TFT). While it was created with set 12 in mind, it should generally work for any TFT set.
## Motivation
So why would you want to **maximize** active trait count? Other than the obvious fact that traits buff and make your team **stronger**, the main inspiration for this project was the augment **Stand United II** and this bad boy:

![TahmKench](https://github.com/user-attachments/assets/5d00be48-b036-48aa-927e-a205c973d88d)

The Arcana trait (*If applied to Tahm Kench*) will give a **team wide** HP buff to all your units.

>**Note**: Both Stand United II and Arcana on Tahm Kench *ONLY* count non-unique active traits that's why for example Bat Queen or Ascendant will not be taken into account

## What the current version can do
Given a team size ***n*** the code will output the names of a combination of units that will maximize the active trait count(The code will choose the lexicographically smaller option in its current form).

## Results
Here are some of the results:

+ ***n=1***: ***No non-unique trait can be activated using that many units!***
+ ***n=2***: ***Ahri Bard***
+ ***n=3***: ***Bard Milio Rakan***
+ ***n=4***: ***Ahri Bard Morgana Zoe***
+ ***n=5***: ***Bard Fiora Gwen Morgana Zoe***
+ ***n=6***: ***Ahri Bard Fiora Gwen Morgana Zoe***
+ ***n=7***: ***Ahri Bard Fiora Gwen Hecarim Morgana Poppy***
+ ***n=8***: ***Ahri Akali Bard Camille Gwen Hecarim Shen Zilean***
+ ***n=9***: ***Bard Ezreal Fiora Galio Gwen Morgana Rumble Ryze Zoe***
+ ***n=10***: ******

