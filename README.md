# Destiny 2 Armor Stat Comparison Tool

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

The application will allow users to add 1 or more sets of armor, with one
armor piece for each slot (head, arms, chest, legs, class item) and view/compare
the stat totals, so they can pick the best combination of armor pieces that suits
their needs. Each armor piece has six stats that appear on them:

- Weapons (0–100: Governs weapon reload speed, handling, and damage versus PvE minor and major combatants. 101–200: Governs ammo restored from bricks, and improves weapon damage versus Guardians and PvE bosses.)
- Class (0–100: Governs class ability cooldowns and energy scalars. 101–200: Governs overshield strength gained upon using your class ability.)
- Health (0–100: Governs flinch resistance and HP restored from Orbs of Power. 101–200: Governs shield capacity in PvE and shield recharge speed.)
- Super (0–100: Governs Super energy scalars. 101–200: Governs Super damage)
- Grenade (0–100: Governs grenade cooldowns and energy scalars. 101–200: Governs grenade damage.)
- Melee (0–100: Governs melee ability cooldowns and energy scalars. 101–200: Governs melee damage, including uncharged melees and Glaives.)

Each stat on an armor piece can have a value ranging from 0 to 40 and all the
stat values from each armor piece are added together to give the total for each
stat. Every 10 stat points on the total increases the effect of each stat up
to a total of 100 for the primary effect and 200 for the secondary effect. Any points
above 200 provides no additional effect

The application will show the stat total from each armor set and allows the user to compare them. It is worth
noting that applications like this already exist and allow users to log into their 
account and pull character data from the Destiny API, but I'll be creating my own
version that is a little more basic and requires manual entry of armor pieces and
stat values. The user will also be able to filter the results to only compare
specific stat values.

This application would be used by Destiny 2 players, but probably mostly by
hardcore players that care a lot about perfecting their build and min/maxing
all their stats. I am interested in making this because I am an avid player
of Destiny 2 (of the variety I just mentioned) and so this is a fun way to create
something cool that relates to one of my favorite video games.

## User Stories

- As a user, I want to add a full set of armor pieces to see what the total stats are
- As a user, I want to add multiple sets of armor to compare their stat
- As a user, I want to remove an armor set that I've added
- As a user, I want to clear all the armor pieces I've added once I'm done
- As a user, I want to save all the sets I've added to a file
- As a user, I want to be able to load armor sets from a file, so I can continue to add more

## Change Log
- July 3, 2025: Updated backend for changes to armor stats coming with the <i>Edge of Fate</i> expansion. The icons will remain the same until the new ones are available.

The following sections were only relevant to the original assignment and are only here for posterity. Please disregard.

## Phase 4: Task 2

Wed Nov 24 11:03:54 PST 2021</br>
Armor piece created with stat total: 72</br>
Wed Nov 24 11:03:54 PST 2021</br>
Armor piece added to set: Emperor's Minister Set</br>
Wed Nov 24 11:03:54 PST 2021</br>
Armor piece created with stat total: 83</br>
Wed Nov 24 11:03:54 PST 2021</br>
Armor piece added to set: Emperor's Minister Set</br>
Wed Nov 24 11:03:54 PST 2021</br>
Armor piece created with stat total: 72</br>
Wed Nov 24 11:03:54 PST 2021</br>
Armor piece added to set: Emperor's Minister Set</br>
Wed Nov 24 11:03:54 PST 2021</br>
Armor piece created with stat total: 77</br>
Wed Nov 24 11:03:54 PST 2021</br>
Armor piece added to set: Emperor's Minister Set</br>
Wed Nov 24 11:03:54 PST 2021</br>
Armor piece created with stat total: 20</br>
Wed Nov 24 11:03:54 PST 2021</br>
Armor piece added to set: Emperor's Minister Set</br>
Wed Nov 24 11:03:54 PST 2021</br>
Armor piece created with stat total: 6</br>
Wed Nov 24 11:03:54 PST 2021</br>
Armor piece added to set: test</br>
Wed Nov 24 11:03:54 PST 2021</br>
Armor piece created with stat total: 6</br>
Wed Nov 24 11:03:54 PST 2021</br>
Armor piece added to set: test</br>
Wed Nov 24 11:03:54 PST 2021</br>
Armor piece created with stat total: 6</br>
Wed Nov 24 11:03:54 PST 2021</br>
Armor piece added to set: test</br>
Wed Nov 24 11:03:54 PST 2021</br>
Armor piece created with stat total: 6</br>
Wed Nov 24 11:03:54 PST 2021</br>
Armor piece added to set: test</br>
Wed Nov 24 11:03:54 PST 2021</br>
Armor piece created with stat total: 6</br>
Wed Nov 24 11:03:54 PST 2021</br>
Armor piece added to set: test</br>
Wed Nov 24 11:03:58 PST 2021</br>
Removed set: Emperor's Minister Set</br>
Wed Nov 24 11:03:58 PST 2021</br>
Removed set: test


## Phase 4: Task 3

- Apply single point of control by changing absolute coordinates to be relative to application window dimensions
- Remove redundant Component variables from UI subcomponent classes
- Abstract code for armor set stat display tables into its own class
- Abstract repeated behavior of subcomponents into a separate parent class
