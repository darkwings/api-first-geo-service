INSERT INTO `geo-service`.Country(id, country_id, phone_code, deleted) VALUES (1, 'it', '39', 0);
INSERT INTO `geo-service`.Country(id, country_id, phone_code, deleted) VALUES (2, 'es', '49', 0);
INSERT INTO `geo-service`.Country(id, country_id, phone_code, deleted) VALUES (3, 'de', '34', 0);

INSERT INTO `geo-service`.localized_data(id, language_id, data) VALUES (1, 'it', 'italia');
INSERT INTO `geo-service`.localized_data(id, language_id, data) VALUES (2, 'en', 'italy');
INSERT INTO `geo-service`.localized_data(id, language_id, data) VALUES (3, 'it', 'spagna');
INSERT INTO `geo-service`.localized_data(id, language_id, data) VALUES (4, 'en', 'spain');
INSERT INTO `geo-service`.localized_data(id, language_id, data) VALUES (5, 'it', 'germania');
INSERT INTO `geo-service`.localized_data(id, language_id, data) VALUES (6, 'en', 'germany');

INSERT INTO `geo-service`.country_localization(country_id, local_id) VALUES (1, 1);
INSERT INTO `geo-service`.country_localization(country_id, local_id) VALUES (1, 2);
INSERT INTO `geo-service`.country_localization(country_id, local_id) VALUES (2, 3);
INSERT INTO `geo-service`.country_localization(country_id, local_id) VALUES (2, 4);
INSERT INTO `geo-service`.country_localization(country_id, local_id) VALUES (3, 5);
INSERT INTO `geo-service`.country_localization(country_id, local_id) VALUES (3, 6);