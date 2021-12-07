# drop table if exists cities_villages;
# drop table if exists regions;

# -- Regions
# CREATE TABLE regions(
#     region_id SERIAL PRIMARY KEY,
#     city_village_name      character varying(255)
# );
#
# -- Cities
# CREATE TABLE cities_villages (
#     city_id   SERIAL PRIMARY KEY,
#     region_id integer,
#     city_village_name      character varying(255),
#     CONSTRAINT cities_region_id_fk FOREIGN KEY(region_id) REFERENCES regions(region_id) ON DELETE RESTRICT
# );

INSERT INTO regions(region_name)
VALUES ('Благоевград');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (1, 'Банско');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (1, 'Белица');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (1, 'Благоевград');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (1, 'Гоце Делчев');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (1, 'Добринище');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (1, 'Кресна');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (1, 'Мелник');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (1, 'Петрич');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (1, 'Разлог');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (1, 'Сандански');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (1, 'Симитли');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (1, 'Хаджидимово');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (1, 'Якоруда');

INSERT INTO regions(region_name)
VALUES ('Бургас');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (2, 'Айтос');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (2, 'Ахтопол');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (2, 'Бургас');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (2, 'Долни чифлик');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (2, 'Каблешково');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (2, 'Камено');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (2, 'Карнобат');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (2, 'Китен');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (2, 'Малко Търново');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (2, 'Несебър');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (2, 'Обзор');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (2, 'Поморие');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (2, 'Приморско');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (2, 'Свети Влас');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (2, 'Созопол');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (2, 'Средец');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (2, 'Сунгурларе');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (2, 'Царево');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (2, 'Ахелой');

INSERT INTO regions(region_name)
VALUES ('Варна');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (3, 'Аксаково');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (3, 'Белослав');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (3, 'Бяла');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (3, 'Варна');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (3, 'Вълчидол');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (3, 'Девня');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (3, 'Дългопол');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (3, 'Провадия');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (3, 'Суворово');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (3, 'Игнатиево');

INSERT INTO regions(region_name)
VALUES ('Велико Търново');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (4, 'Бяла черква');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (4, 'Велико Търново');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (4, 'Горна Оряховица');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (4, 'Дебелец');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (4, 'Долна Оряховица');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (4, 'Елена');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (4, 'Златарица');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (4, 'Килифарево');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (4, 'Лясковец');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (4, 'Павликени');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (4, 'Полски Тръмбеш');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (4, 'Свищов');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (4, 'Стражица');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (4, 'Сухиндол');

INSERT INTO regions(region_name)
VALUES ('Видин');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (5, 'Белоградчик');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (5, 'Брегово');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (5, 'Видин');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (5, 'Грамада');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (5, 'Димово');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (5, 'Дунавци');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (5, 'Кула');

INSERT INTO regions(region_name)
VALUES ('Враца');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (6, 'Бяла Слатина');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (6, 'Враца');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (6, 'Козлодуй');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (6, 'Криводол');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (6, 'Мездра');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (6, 'Мизия');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (6, 'Оряхово');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (6, 'Роман');

INSERT INTO regions(region_name)
VALUES ('Габрово');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (7, 'Габрово');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (7, 'Дряново');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (7, 'Плачковци');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (7, 'Севлиево');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (7, 'Трявна');

INSERT INTO regions(region_name)
VALUES ('Добрич');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (8, 'Балчик');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (8, 'Генерал Тошево');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (8, 'Добрич');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (8, 'Каварна');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (8, 'Тервел');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (8, 'Шабла');

INSERT INTO regions(region_name)
VALUES ('Кърджали');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (9, 'Ардино');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (9, 'Джебел');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (9, 'Крумовград');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (9, 'Кърджали');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (9, 'Момчилград');

INSERT INTO regions(region_name)
VALUES ('Кюстендил');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (10, 'Бобов дол');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (10, 'Бобошево');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (10, 'Дупница');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (10, 'Кочериново');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (10, 'Кюстендил');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (10, 'Рила');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (10, 'Сапарева баня');

INSERT INTO regions(region_name)
VALUES ('Ловеч');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (11, 'Априлци');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (11, 'Летница');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (11, 'Ловеч');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (11, 'Луковит');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (11, 'Тетевен');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (11, 'Троян');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (11, 'Угърчин');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (11, 'Ябланица');

INSERT INTO regions(region_name)
VALUES ('Монтана');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (12, 'Берковица');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (12, 'Бойчиновци');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (12, 'Брусарци');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (12, 'Вълчедръм');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (12, 'Вършец');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (12, 'Лом');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (12, 'Монтана');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (12, 'Чипровци');

INSERT INTO regions(region_name)
VALUES ('Пазарджик');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (13, 'Батак');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (13, 'Белово');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (13, 'Брацигово');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (13, 'Велинград');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (13, 'Ветрен');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (13, 'Костандово');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (13, 'Пазарджик');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (13, 'Панагюрище');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (13, 'Пещера');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (13, 'Ракитово');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (13, 'Септември');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (13, 'Стрелча');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (13, 'Сърница');

INSERT INTO regions(region_name)
VALUES ('Перник');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (14, 'Батановци');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (14, 'Брезник');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (14, 'Земен');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (14, 'Перник');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (14, 'Радомир');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (14, 'Трън');

INSERT INTO regions(region_name)
VALUES ('Плевен');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (15, 'Белене');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (15, 'Гулянци');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (15, 'Долна Митрополия');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (15, 'Долни Дъбник');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (15, 'Искър');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (15, 'Кнежа');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (15, 'Койнаре');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (15, 'Левски');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (15, 'Никопол');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (15, 'Плевен');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (15, 'Пордим');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (15, 'Славяново');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (15, 'Тръстеник');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (15, 'Червен бряг');

INSERT INTO regions(region_name)
VALUES ('Пловдив');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (16, 'Асеновград');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (16, 'Баня');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (16, 'Брезово');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (16, 'Калофер');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (16, 'Карлово');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (16, 'Клисура');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (16, 'Кричим');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (16, 'Куклен');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (16, 'Лъки');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (16, 'Перущица');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (16, 'Пловдив');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (16, 'Първомай');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (16, 'Раковски');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (16, 'Садово');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (16, 'Сопот');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (16, 'Стамболийски');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (16, 'Съединение');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (16, 'Хисаря');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (16, 'Баня');

INSERT INTO regions(region_name)
VALUES ('Разград');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (17, 'Завет');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (17, 'Исперих');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (17, 'Кубрат');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (17, 'Лозница');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (17, 'Разград');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (17, 'Цар Калоян');

INSERT INTO regions(region_name)
VALUES ('Русе');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (18, 'Борово');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (18, 'Бяла');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (18, 'Ветово');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (18, 'Глоджево');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (18, 'Две могили');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (18, 'Мартен');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (18, 'Русе');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (18, 'Сеново');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (18, 'Сливо поле');

INSERT INTO regions(region_name)
VALUES ('Силистра');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (19, 'Алфатар');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (19, 'Главиница');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (19, 'Дулово');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (19, 'Силистра');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (19, 'Тутракан');

INSERT INTO regions(region_name)
VALUES ('Сливен');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (20, 'Кермен');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (20, 'Котел');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (20, 'Нова Загора');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (20, 'Сливен');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (20, 'Твърдица');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (20, 'Шивачево');

INSERT INTO regions(region_name)
VALUES ('Смолян');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (21, 'Девин');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (21, 'Доспат');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (21, 'Златоград');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (21, 'Мадан');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (21, 'Неделино');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (21, 'Рудозем');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (21, 'Смолян');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (21, 'Чепеларе');

INSERT INTO regions(region_name)
VALUES ('София');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (22, 'Банкя');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (22, 'Божурище');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (22, 'Ботевград');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (22, 'Бухово');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (22, 'Българово');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (22, 'Годеч');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (22, 'Долна баня');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (22, 'Драгоман');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (22, 'Елин Пелин');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (22, 'Етрополе');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (22, 'Златица');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (22, 'Ихтиман');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (22, 'Копривщица');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (22, 'Костенец');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (22, 'Костинброд');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (22, 'Момин проход');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (22, 'Нови Искър');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (22, 'Пирдоп');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (22, 'Правец');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (22, 'Самоков');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (22, 'Своге');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (22, 'Сливница');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (22, 'София');

INSERT INTO regions(region_name)
VALUES ('Стара Загора');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (23, 'Гурково');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (23, 'Гълъбово');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (23, 'Казанлък');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (23, 'Мъглиж');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (23, 'Николаево');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (23, 'Павел баня');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (23, 'Раднево');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (23, 'Стара Загора');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (23, 'Чирпан');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (23, 'Шипка');

INSERT INTO regions(region_name)
VALUES ('Търговище');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (23, 'Антоново');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (23, 'Омуртаг');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (23, 'Опака');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (23, 'Попово');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (23, 'Търговище');

INSERT INTO regions(region_name)
VALUES ('Хасково');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (24, 'Върбица');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (24, 'Димитровград');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (24, 'Ивайловград');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (24, 'Любимец');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (24, 'Маджарово');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (24, 'Меричлери');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (24, 'Свиленград');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (24, 'Симеоновград');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (24, 'Тополовград');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (24, 'Харманли');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (24, 'Хасково');

INSERT INTO regions(region_name)
VALUES ('Шумен');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (25, 'Върбица');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (25, 'Димитровград');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (25, 'Ивайловград');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (25, 'Любимец');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (25, 'Маджарово');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (25, 'Меричлери');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (25, 'Свиленград');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (25, 'Симеоновград');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (25, 'Тополовград');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (25, 'Харманли');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (25, 'Хасково');

INSERT INTO regions(region_name)
VALUES ('Ямбол');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (26, 'Елхово');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (26, 'Стралджа');
INSERT INTO cities_villages(region_id, city_village_name)
VALUES (26, 'Ямбол');


# VEHICLE YEARS
INSERT INTO vehicle_year(vehicle_year)
VALUES (1988);
INSERT INTO vehicle_year(vehicle_year)
VALUES (1989);
INSERT INTO vehicle_year(vehicle_year)
VALUES (1990);
INSERT INTO vehicle_year(vehicle_year)
VALUES (1991);
INSERT INTO vehicle_year(vehicle_year)
VALUES (1992);
INSERT INTO vehicle_year(vehicle_year)
VALUES (1993);
INSERT INTO vehicle_year(vehicle_year)
VALUES (1994);
INSERT INTO vehicle_year(vehicle_year)
VALUES (1995);
INSERT INTO vehicle_year(vehicle_year)
VALUES (1996);
INSERT INTO vehicle_year(vehicle_year)
VALUES (1997);
INSERT INTO vehicle_year(vehicle_year)
VALUES (1998);
INSERT INTO vehicle_year(vehicle_year)
VALUES (1999);
INSERT INTO vehicle_year(vehicle_year)
VALUES (2000);
INSERT INTO vehicle_year(vehicle_year)
VALUES (2001);
INSERT INTO vehicle_year(vehicle_year)
VALUES (2002);
INSERT INTO vehicle_year(vehicle_year)
VALUES (2003);
INSERT INTO vehicle_year(vehicle_year)
VALUES (2004);
INSERT INTO vehicle_year(vehicle_year)
VALUES (2005);
INSERT INTO vehicle_year(vehicle_year)
VALUES (2006);
INSERT INTO vehicle_year(vehicle_year)
VALUES (2007);
INSERT INTO vehicle_year(vehicle_year)
VALUES (2008);
INSERT INTO vehicle_year(vehicle_year)
VALUES (2009);
INSERT INTO vehicle_year(vehicle_year)
VALUES (2010);
INSERT INTO vehicle_year(vehicle_year)
VALUES (2011);
INSERT INTO vehicle_year(vehicle_year)
VALUES (2012);
INSERT INTO vehicle_year(vehicle_year)
VALUES (2013);
INSERT INTO vehicle_year(vehicle_year)
VALUES (2014);
INSERT INTO vehicle_year(vehicle_year)
VALUES (2015);
INSERT INTO vehicle_year(vehicle_year)
VALUES (2016);
INSERT INTO vehicle_year(vehicle_year)
VALUES (2017);
INSERT INTO vehicle_year(vehicle_year)
VALUES (2018);
INSERT INTO vehicle_year(vehicle_year)
VALUES (2019);
INSERT INTO vehicle_year(vehicle_year)
VALUES (2020);
INSERT INTO vehicle_year(vehicle_year)
VALUES (2021);
INSERT INTO vehicle_year(vehicle_year)
VALUES (2022);

# #VEHICLE CATEGORY
#
# INSERT INTO vehicle_category(vehicle_category_name) VALUES ('CAR');
# INSERT INTO vehicle_category(vehicle_category_name) VALUES ('CAR');
# INSERT INTO vehicle_category(vehicle_category_name) VALUES ('BUS');
# INSERT INTO vehicle_category(vehicle_category_name) VALUES ('MOTORCYCLE');
# INSERT INTO vehicle_category(vehicle_category_name) VALUES ('TRUCK');

# # VEHICLE BRANDS - CATEGORIES
#
# INSERT INTO vehicle_brands(id, brand_name)
# VALUES (3, 'AUDI');
# INSERT INTO vehicle_brands(id, brand_name)
# VALUES (4, 'BMW');
# INSERT INTO vehicle_brands(id, brand_name)
# VALUES (5, 'FIAT');
# INSERT INTO vehicle_brands(id, brand_name)
# VALUES (6, 'FORD');
# INSERT INTO vehicle_brands(id, brand_name)
# VALUES (10, 'MERCEDES-BENZ');
# # TRUCK
# INSERT INTO vehicle_brands(id, brand_name)
# VALUES (18, 'VOLVO');
# INSERT INTO vehicle_brands(id, brand_name)
# VALUES (19, 'MERCEDES-BENZ');
# INSERT INTO vehicle_brands(id, brand_name)
# VALUES (20, 'International');
# INSERT INTO vehicle_brands(id, brand_name)
# VALUES (21, 'Freightliner');
# INSERT INTO vehicle_brands(id, brand_name)
# VALUES (22, 'RENAULT');
# # MOTORCYCLE
# INSERT INTO vehicle_brands(id, brand_name)
# VALUES (23, 'Honda');
# INSERT INTO vehicle_brands(id, brand_name)
# VALUES (24, 'Yamaha');
# INSERT INTO vehicle_brands(id, brand_name)
# VALUES (25, 'Suzuki');
# # BUS
# INSERT INTO vehicle_brands(id, brand_name)
# VALUES (26, 'Daimler');
# INSERT INTO vehicle_brands(id, brand_name)
# VALUES (27, 'MAN');

# # BRAND CATEGORY _ ONE TO MANY
# INSERT INTO vehicle_brands_category(brand_entity_id, category_id) VALUES (3,1);
# INSERT INTO vehicle_brands_category(brand_entity_id, category_id) VALUES (4,1);
# INSERT INTO vehicle_brands_category(brand_entity_id, category_id) VALUES (5,1);
# INSERT INTO vehicle_brands_category(brand_entity_id, category_id) VALUES (6,1);
# INSERT INTO vehicle_brands_category(brand_entity_id, category_id) VALUES (10,1);
# INSERT INTO vehicle_brands_category(brand_entity_id, category_id) VALUES (18,4);
# INSERT INTO vehicle_brands_category(brand_entity_id, category_id) VALUES (19,4);
# INSERT INTO vehicle_brands_category(brand_entity_id, category_id) VALUES (20,4);
# INSERT INTO vehicle_brands_category(brand_entity_id, category_id) VALUES (21,4);
# INSERT INTO vehicle_brands_category(brand_entity_id, category_id) VALUES (22,4);
# INSERT INTO vehicle_brands_category(brand_entity_id, category_id) VALUES (23,3);
# INSERT INTO vehicle_brands_category(brand_entity_id, category_id) VALUES (24,3);
# INSERT INTO vehicle_brands_category(brand_entity_id, category_id) VALUES (25,3);
# INSERT INTO vehicle_brands_category(brand_entity_id, category_id) VALUES (26,2);
# INSERT INTO vehicle_brands_category(brand_entity_id, category_id) VALUES (27,2);
#
#
#
# # CAR MODELS - BRANDS
# INSERT INTO vehicle_models(id, model_name, brand_id)
# VALUES
#        (14, 'A3', 3),
#        (15, 'A6', 3),
#        (16, 'A8', 3),
#        (17, 'Q8', 3),
#        (18, 'Q3', 3),
#        (19, 'X6', 4),
#        (20, 'X5', 4),
#        (21, 'X3', 4),
#        (22, '550', 4),
#        (23, 'Punto', 5),
#        (24, 'Brava', 5),
#        (25, '500X', 5),
#        (26, 'Bravo', 5),
#        (27, 'Tipo', 5),
#        (28, 'Tempra', 5),
#        (29, 'MUSTANG', 6),
#        (30, 'Escape', 6),
#        (31, 'Escort', 6),
#        (32, 'Focus', 6),
#        (33, 'GLA', 10),
#        (34, 'S-Class', 10),
#        (35, 'GLS', 10),
#        #TRUCK MODELS
#        (36, 'Condor', 21),
#        (37, 'EconicSD', 21),
#        (38, 'Cargo FC70 FC80', 21),
#        (39, 'Transtar', 20),
#        (40, 'International 9000', 20),
#        (41, 'International 9000i', 20),
#        (42, 'FH16', 18),
#        (43, 'FM500', 18),
#        (44, 'LV63', 18),
#        (45, 'LG65/2', 19),
#        (46, 'LG65/4', 19),
#        (47, 'Kerax', 22),
#        (48, 'Master', 22),
#        (49, 'Maxity', 22),
#        # MOTORCYCLE MODELS
#        (50, 'CBR1000RR-R SP', 23),
#        (51, 'CB1000R', 23),
#        (52, 'X-ADV', 23),
#        (53, 'CBR600RR', 23),
#        (54, 'MT-09 / FZ-09', 24),
#        (55, 'AG125', 24),
#        (56, 'BW200', 24),
#        (57, 'FJ1200 ABS', 24),
#        (58, 'Ray ZR', 24),
#        (59, 'Boulevard C50 (VL800 Volusia)', 25),
#        (60, 'Boulevard C90 (Intruder VL1500))', 25),
#        (61, 'Boulevard M50 (Intruder M800)', 25),
#        (62, 'VS400', 25),
#        (63, 'VS1400', 25),
#        # BUS MODELS
#        (64, 'OC 500 LE', 26),
#        (65, 'Tourismo', 26),
#        (66, 'Double-deck city bus', 27),
#        (67, 'Low-entry city bus', 27),
#        (68, 'Low-floor city bus', 27),
#        (69, 'Low-floor articulated city bus', 27);
#
#
# # CAR YEAR - MODELS
# INSERT INTO vehicle_models_vehicle_year(model_entity_id, vehicle_year_id)
# VALUES (1, 2),
#        (1, 5),
#        (1, 6),
#        (1, 8),
#        (1, 11),
#        (1, 15),
#        (1, 25),
#        (1, 9),
#        (1, 34),
#        (1, 30),
#        (2, 5),
#        (2, 1),
#        (2, 2),
#        (2, 3),
#        (2, 4),
#        (2, 5),
#        (2, 6),
#        (2, 7),
#        (2, 8),
#        (2, 9),
#        (2, 10),
#        (2, 15),
#        (2, 17),
#        (2, 19),
#        (2, 25),
#        (3, 2),
#        (3, 5),
#        (3, 6),
#        (3, 8),
#        (3, 11),
#        (3, 15),
#        (3, 25),
#        (3, 9),
#        (3, 34),
#        (3, 30),
#        (4, 5),
#        (4, 1),
#        (4, 2),
#        (4, 3),
#        (4, 4),
#        (4, 5),
#        (4, 6),
#        (4, 7),
#        (4, 8),
#        (4, 9),
#        (4, 10),
#        (4, 15),
#        (4, 17),
#        (4, 19),
#        (4, 25),
#        (5, 2),
#        (5, 5),
#        (5, 6),
#        (5, 8),
#        (5, 11),
#        (5, 15),
#        (5, 25),
#        (5, 9),
#        (5, 34),
#        (5, 30),
#        (5, 5),
#        (5, 1),
#        (6, 2),
#        (6, 3),
#        (6, 4),
#        (6, 5),
#        (6, 6),
#        (6, 7),
#        (6, 8),
#        (6, 9),
#        (6, 10),
#        (6, 15),
#        (6, 17),
#        (6, 19),
#        (6, 25),
#        (7, 2),
#        (7, 5),
#        (7, 6),
#        (7, 8),
#        (8, 11),
#        (8, 15),
#        (8, 25),
#        (8, 9),
#        (9, 34),
#        (9, 30),
#        (9, 5),
#        (10, 1),
#        (10, 2),
#        (11, 3),
#        (11, 4),
#        (12, 5),
#        (12, 6),
#        (13, 7),
#        (14, 8),
#        (14, 9),
#        (14, 10),
#        (15, 15),
#        (15, 17),
#        (15, 19),
#        (16, 25),
#        (17, 2),
#        (17, 5),
#        (17, 6),
#        (18, 8),
#        (18, 11),
#        (18, 15),
#        (19, 25),
#        (19, 9),
#        (19, 34),
#        (19, 30),
#        (20, 5),
#        (20, 1),
#        (20, 2),
#        (21, 3),
#        (21, 4),
#        (21, 5),
#        (21, 6),
#        (21, 7),
#        (22, 8),
#        (22, 9),
#        (22, 10),
#        (22, 15),
#        (22, 17),
#        (22, 19),
#        (22, 25),
#        (23, 2),
#        (23, 5),
#        (23, 6),
#        (24, 8),
#        (24, 11),
#        (24, 15),
#        (24, 25),
#        (25, 9),
#        (25, 34),
#        (25, 30),
#        (26, 5),
#        (27, 1),
#        (28, 2),
#        (29, 3),
#        (30, 4),
#        (31, 5),
#        (31, 6),
#        (31, 7),
#        (32, 8),
#        (33, 9),
#        (34, 10),
#        (35, 15),
#        (36, 17),
#        (36, 19),
#        (37, 25),
#        (38, 2),
#        (39, 5),
#        (40, 6),
#        (41, 8),
#        (41, 11),
#        (42, 15),
#        (43, 25),
#        (44, 9),
#        (45, 34),
#        (47, 30),
#        (46, 5),
#        (48, 1),
#        (49, 2),
#        (50, 3),
#        (51, 4),
#        (52, 5),
#        (53, 6),
#        (54, 7),
#        (55, 8),
#        (56, 9),
#        (57, 10),
#        (58, 15),
#        (59, 17),
#        (60, 19),
#        (61, 25),
#        (62, 2),
#        (63, 5),
#        (64, 6),
#        (65, 8),
#        (66, 11),
#        (67, 15),
#        (68, 25),
#        (69, 9);



# // EXTERIOR COLORS
# INSERT INTO vehicle_exterior_color(exterior_color_enum) VALUE ('red');
# INSERT INTO vehicle_exterior_color(exterior_color_enum) VALUE ('yellow');
# INSERT INTO vehicle_exterior_color(exterior_color_enum) VALUE ('blue');
# INSERT INTO vehicle_exterior_color(exterior_color_enum) VALUE ('brown');
# INSERT INTO vehicle_exterior_color(exterior_color_enum) VALUE ('orange');
# INSERT INTO vehicle_exterior_color(exterior_color_enum) VALUE ('green');
# INSERT INTO vehicle_exterior_color(exterior_color_enum) VALUE ('violet');
# INSERT INTO vehicle_exterior_color(exterior_color_enum) VALUE ('black');
# INSERT INTO vehicle_exterior_color(exterior_color_enum) VALUE ('carnation_pink');
# INSERT INTO vehicle_exterior_color(exterior_color_enum) VALUE ('yellow_orange');
# INSERT INTO vehicle_exterior_color(exterior_color_enum) VALUE ('blue_green');
# INSERT INTO vehicle_exterior_color(exterior_color_enum) VALUE ('red_violet');
# INSERT INTO vehicle_exterior_color(exterior_color_enum) VALUE ('red_orange');
# INSERT INTO vehicle_exterior_color(exterior_color_enum) VALUE ('yellow_green');
# INSERT INTO vehicle_exterior_color(exterior_color_enum) VALUE ('blue_violet');
# INSERT INTO vehicle_exterior_color(exterior_color_enum) VALUE ('white');
# INSERT INTO vehicle_exterior_color(exterior_color_enum) VALUE ('dandelion');
# INSERT INTO vehicle_exterior_color(exterior_color_enum) VALUE ('cerulean');
# INSERT INTO vehicle_exterior_color(exterior_color_enum) VALUE ('apricot');
# INSERT INTO vehicle_exterior_color(exterior_color_enum) VALUE ('scarlet');
# INSERT INTO vehicle_exterior_color(exterior_color_enum) VALUE ('metallic_black');