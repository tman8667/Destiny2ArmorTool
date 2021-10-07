# Destiny 2 Armor Build Creator

## Background

Destiny 2 is a live-service MMO first-person shooter game developed by Bungie
and released in 2017. The game is set in the far future, and you play as a
Guardian, defenders of the last safe city and wielders of the Light, a power
given to you by the Traveller after humanity was destroyed by its ancient enemy,
the Darkness. This game is a looter-shooter, meaning you can get random weapon
and armor drops from everywhere in the game, and you want to hunt down the best
rolls for traits on weapons and stats on armor. Each armor piece has 6 
different stats on it that affect your character abilities and are random on
each drop of armor piece you get. A lot of people want to pick a combination
of armor to get a certain total for each stat to suit the build they are running.
This tool will help players achieve this.

## The Application

The application will allow users to add at least 2 (but probably no more than 5 or 6 because of processing time) 
armor pieces for each slot (head, arms, chest, legs, class item) and generate combinations of those armor 
pieces, so they can pick the best combination of armor pieces that suits
their needs. Each armor piece has six stats that appear on them:

- Mobility (affects movement speed and jump height)
- Recovery (affects how quickly you start regenerating health)
- Resilience (affects how much damage you take from enemy combatants or players)
- Intellect (affects how quickly your Super ability recharges)
- Discipline (affects how quickly your Grenade ability recharges)
- Strength (affects how quickly your Melee ability recharges)

Each stat on an armor piece can have a value ranging from 0 to 40 and all the
stat values from each armor piece are added together to give the total for each
stat. Every 10 stat points on the total increases the effect of each stat up
to a total of 100, above which additional stat points do not give any more effect.

The application will show every stat total from each combination of armor. It is worth
noting that applications like this already exist and allow users to log into their 
account and pull character data from the Destiny API, but I'll be creating my own
version that is a little more basic and requires manual entry of armor pieces and
stat values. The user will also be able to filter the results for instance to only
look at combinations that have more than 70 intellect for instance.

This application would be used by Destiny 2 players, but probably mostly by
hardcore players that care a lot about perfecting their build and min/maxing
all their stats. I am interested in making this because I am an avid player
of Destiny 2 (of the variety I just mentioned) and so this is a fun way to create
something cool that relates to one of my favorite video games.