START TRANSACTION;

--
-- Base de datos: `eigatracker`
--

--
-- Volcado de datos para la tabla `peliculas`
--

INSERT INTO `peliculas` (`nombre`, `notas`, `conocida`) VALUES
('Kung-fu Panda 1', 'Poo es un panda que hace ramen cuando descubre que es el guerrero del drago y tiene que derrotar a tailung', 1),
('Kung-fu Panda 2', 'Un pavo real blanco llamado \"Zen\" consigue hacer el primer cañon militar y desea conquistar toda china\n y Poo debe detenerlo junto a los 5', 1),
('Rise of the Guardians', 'Cool magic known people like santa fight against a nightmare guy with the protagonist knowing frost magic.\nJack Frost and Tooth Fairy ship hitting hard xD.', 1);

--
-- Volcado de datos para la tabla `registros_peliculas`
--

INSERT INTO `registros_peliculas` (`notas`, `comprension`, `diversion`, `fecha`, `PELICULA_REF`) VALUES
( 'primera pelicula', 10, 40, '2022-06-24 22:00:00', 'kung-fu panda 1'),
( 'segunda repeticion', 20, 70, '2022-06-25 22:00:00', 'kung-fu panda 1'),
( 'Esta vez he entendido mas frases, he incluso alguna palabra solo de oido', 27, 60, '2022-06-27 10:09:30', 'kung-fu panda 1'),
( 'Primera visualizacion en japones', 10, 50, '2022-06-25 22:00:00', 'Kung-fu Panda 2'),
( 'Sigo sin entender la mayoria, pero tigresa esta buena.', 13, 35, '2022-06-28 14:50:30', 'Kung-fu Panda 2'),
( 'Me diverti en las partes q entendia, pero en el resto me aburri bastante. Pero la verdad es q entiendo mas q antes.', 35, 48, '2022-06-29 10:27:06', 'kung-fu panda 1'),
( 'He entendido bastantes palabras de oido, como por ejemplo \"miru\" que significa mirar o ver. Pero por lo general diria que he mejorado bastante desde mi ultima visualizacion de esta pelicula.', 19, 40, '2022-06-30 10:11:01', 'kung-fu panda 2'),
( 'The ship between those two got me craving for more, but I think I understood the word belive here.', 7, 80, '2022-07-01 22:10:46', 'Rise of the Guardians'),
( '\"Washi\" is short of \"watashi\" and \"washita\" is short of \"watashitachi\", I think the verb \"Belive\" is said \"shinji\". I really enjoy this movie but the kids ending kills me every time :/...', 9, 60, '2022-07-02 12:03:41', 'Rise of the Guardians'),
( 'Wtf you can say \"Boku no na ha Hugo desu\" instead of \"namae ha\"????...  Weird.\nI could diferenciate words and even recognice some like \"daze\" or something like that, I dont remember.', 15, 75, '2022-07-03 10:26:18', 'Rise of the Guardians');

--
-- Volcado de datos para la tabla `series`
--

INSERT INTO `series` (`nombre`, `notas`) VALUES
('Firends', 'Un grupo de amigos tienen vidas normales pero ellos no lo son tanto.');
COMMIT;
