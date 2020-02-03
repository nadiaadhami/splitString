# splitString
Goal: split a string into dictionary words.

1. The entire string must be consumed.
2. Break the string into exactly two words.
3. If more than one split is possible, return any one (or all) of the valid splits.
4. If no split is possible, return something that distinguishes it from the case where there is a valid split.

dictionary: a rock rocks star stars tar


rock => rock

rockstar    => "rock" "star" OR "rocks" "tar"

zebra       => no valid split

rockstartar => no valid split  “rock” star tar | rocks tar tar aa
