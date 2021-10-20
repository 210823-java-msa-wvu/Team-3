create table users (
	id serial not null,
	username VARCHAR not null,
	password VARCHAR not null
);

create table characters (
	id serial primary key,
	charactername VARCHAR not null,
	ac INTEGER not null,
	health INTEGER not null	
);

create table messages (
	id serial primary key,
	message VARCHAR not null
);


create table cards(
	id serial primary key,
	cardname VARCHAR not null,
	description VARCHAR not null
);

insert into cards values
(default, 'Balance', 'Your mind suffers a wrenching alternation, causing your Alignment to change. Lawful becomes chaotic, good becomes evil, and vice versa. If you are true neutrual or unaligned, this card has no Effect on you'),
(default, 'Comet', 'If you single-handely defeat the next Hostile monster or group of Monsters you encounter, you gain Experience Points enough to gain one Level. Otherwise, this card has no Effect.'),
(default, 'Donjin', 'You disappear and become entombed in a state of suspended animation in an extradimensional Sphere. Everything you were wearing and carrying stays behind in the space you occupied when you disappeared. You remain imprisoned until you are found and removed from the Sphere. You can''t be located by any Divination magic, but a wish spell can reveal the Location of your prison, You draw no more cards.'),
(default, 'Euryale', 'This card''s medusa-like visage Curses you. You take a -2 penalty on Saving Throws while Cursed in this way. Only a god or the magic of The Fates card can end this curse.'),
(default, 'The Fates', 'Reality''s fabric unravels and spins anew, allowing you to avoid or erase one event as if it never happened. You can use the card''s magic as soon as you draw this card or at any other time before you die.'),
(default, 'Flame', 'A powerful devil becomes your enemy. The devil seeks your ruin and plagues your life, savoring your suffering before attempting to slay ou. This enmity lasts until either you or the devil dies.'),
(default, 'Fool', 'You lose 10,000 XP, discard this card, and draw from the deck again, counting both draws as one of your declared draws. If losing that much XP would cause you to lose a level, you instead lose an amount that leaves you with just enough XP to keep your level.'),
(default, 'Gem', 'Twenty-five pieces of jewelry worth 2,000 gp each or fifty gems worth 1,000 gp each appear at your feet.'),
(default, 'Idiot', 'Permanently reduce your Intelligence by 1d4 + 1((to a minimum score of 1)). You can draw one additional card beyond your declared draws.');