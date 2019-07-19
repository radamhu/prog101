2.

3.

SELECT
    faj,
    ROUND(`kormeret` / 100, 2) AS "Körméret méterben"
FROM
    `fa`
WHERE
    `kormeret` > 900
ORDER BY
    faj;
	
4.

SELECT
    faj,
    ROUND(`kormeret` / 100 * 2 * 3.1415, 2) AS "Körméret",
    meres AS "Év"
FROM
    `fa`
ORDER BY
    ROUND(`kormeret` / 100 * 2 * PI(), 2)
DESC
LIMIT 1;

5.

SELECT
    megye.nev AS "Név",
    fa.telepules,
    COUNT(fa.faj) AS "Db"
FROM
    megye
INNER JOIN fa ON(megye.id = fa.megyeid)
GROUP BY
    fa.faj
ORDER BY
    COUNT(fa.faj)
DESC, fa.telepules;

6.

SELECT
    megye.nev AS "Név",
    COUNT(fa.faj) AS "Db"
FROM
    megye
INNER JOIN fa ON(megye.id = fa.megyeid)
GROUP BY
    fa.megyeid
ORDER BY
    megye.nev;

7.

SELECT DISTINCT
    faj
FROM
    fa
WHERE
    telepules IN(
    SELECT
        telepules
    FROM
        fa
    WHERE
        faj = 'tiszafa'
) AND faj != 'tiszafa'
ORDER BY
    fa.faj;


