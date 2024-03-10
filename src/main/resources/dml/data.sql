INSERT INTO store (id, store_name, lat, lng) VALUES
                                            (1, 'Atasehir MMM Migros', 40.9923307, 29.1244229),
                                            (2, 'Novada MMM Migros', 40.986106, 29.1161293),
                                            (3, 'Beylikduzu 5M Migros', 41.0066851, 28.6552262),
                                            (4, 'Ortakoy MMM Migros', 41.055783, 29.0210292),
                                            (5, 'Caddebostan MMM Migros', 40.9632463, 29.0630908);
INSERT INTO courier(id, courier_name, license_plate) VALUES
                                            (1, 'Halit Mancar', '34MMM34'),
                                            (2, 'Ahmet Acar', '34MMM35'),
                                            (3, 'Mehmet Secer', '34MMM36'),
                                            (4, 'Selim Yasar', '34MMM37'),
                                            (5, 'Metin Serdivan', '34MMM38'),
                                            (6, 'Recep Sahin', '34MMM39'),
                                            (7, 'Remzi Mars', '34MMM40'),
                                            (8, 'Melih Ture', '34MMM41'),
                                            (9, 'Sevim Yenilmez', '34MMM42'),
                                            (10, 'Serhat Gunes', '34MMM43');

INSERT INTO total_distance(id, courier_id, last_seen_lat, last_seen_lng, total_distance_travelled) VALUES
                                                         (1, 1, 40.968191, 29.096219, 0),
                                                         (2, 2, 41.044927, 29.016921, 0),
                                                         (3, 3, 41.004844, 28.667931, 0),
                                                         (4, 4, 40.980769, 29.086387, 0),
                                                         (5, 5, 40.980059, 29.106996, 0),
                                                         (6, 6, 40.998191, 29.126219, 0),
                                                         (7, 7, 40.975927, 29.103921, 0),
                                                         (8, 8, 41.000014, 28.687931, 0),
                                                         (9, 9, 41.088769, 29.002387, 0),
                                                         (10, 10, 40.947659, 29.036996, 0);