{\rtf1\ansi\ansicpg1252\cocoartf2639
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\paperw11900\paperh16840\margl1440\margr1440\vieww11520\viewh8400\viewkind0
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0

\f0\fs24 \cf0 SELECT u.user_id, u.username, td.training_id, td.training_date, COUNT(*) AS count\
FROM User u\
JOIN Training_details td ON u.user_id = td.user_id\
WHERE td.training_date IN (\
  SELECT training_date\
  FROM Training_details\
  GROUP BY training_date\
  HAVING COUNT(*) > 1\
)\
GROUP BY u.user_id, td.training_id, td.training_date\
HAVING COUNT(*) > 1\
ORDER BY td.training_date DESC\
}