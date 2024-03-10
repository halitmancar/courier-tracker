INSERT INTO store (id, store_name, lat, lng) VALUES
                                            (1, 'Ataşehir MMM Migros', 40.9923307, 29.1244229),
                                            (2, 'Novada MMM Migros', 40.986106, 29.1161293),
                                            (3, 'Beylikdüzü 5M Migros', 41.0066851, 28.6552262),
                                            (4, 'Ortaköy MMM Migros', 41.055783, 29.0210292),
                                            (5, 'Caddebostan MMM Migros', 40.9632463, 29.0630908);
INSERT INTO courier(id, courier_name, license_plate) VALUES
                                            (1, 'Halit Mancar', '34MMM34'),
                                            (2, 'Ahmet Acar', '34MMM35'),
                                            (3, 'Mehmet Seçer', '34MMM36'),
                                            (4, 'Selim Yaşar', '34MMM37'),
                                            (5, 'Metin Serdivan', '34MMM38'),
                                            (6, 'Recep Şahin', '34MMM39'),
                                            (7, 'Remzi Mars', '34MMM40'),
                                            (8, 'Melih Türe', '34MMM41'),
                                            (9, 'Sevim Yenilmez', '34MMM42'),
                                            (10, 'Serhat Güneş', '34MMM43');

INSERT INTO total_distance(id, courier_id, last_seen_lat, last_seen_lng, total_distance_travelled) VALUES
                                                         (1, 1, 40.968191, 29.096219, 1500),
                                                         (2, 2, 41.044927, 29.016921, 0),
                                                         (3, 3, 41.004844, 28.667931, 0),
                                                         (4, 4, 40.980769, 29.086387, 0),
                                                         (5, 5, 40.980059, 29.106996, 0),
                                                         (6, 6, 40.998191, 29.126219, 0),
                                                         (7, 7, 40.975927, 29.103921, 0),
                                                         (8, 8, 41.000014, 28.687931, 0),
                                                         (9, 9, 41.088769, 29.002387, 0),
                                                         (10, 10, 40.947659, 29.036996, 0);

INSERT INTO courier_location_log(id, courier_id, lat, lng, time) VALUES
                                                        (10, 1, 40.9684, 29.0965, '2024-03-10T20:40:47.901486Z'),
                                                        (20, 1, 40.9624, 29.0995, '2024-03-10T20:40:54.901486Z'),
                                                        (30, 1, 40.9604, 29.1015, '2024-03-10T20:41:01.901486Z'),
                                                        (40, 1, 40.9554, 29.1065, '2024-03-10T20:41:08.901486Z'),
                                                        (50, 1, 40.9524, 29.1095, '2024-03-10T20:41:15.901486Z');

INSERT INTO courier_zone_entry(id, courier_id, store_id, time, lat, lng) VALUES
                                                        (10, 2, 4, '2024-03-10T20:41:01.901486Z', 40.9684, 29.0965),
                                                        (20, 2, 2, '2024-03-10T20:43:01.901486Z', 40.9812, 29.0754),
                                                        (30, 1, 1, '2024-03-10T20:45:01.901486Z', 41.0184, 29.0113),
                                                        (40, 1, 3, '2024-03-10T20:46:01.901486Z', 40.9908, 28.9762),
                                                        (50, 5, 5, '2024-03-10T20:48:01.901486Z', 40.9684, 28.9912);