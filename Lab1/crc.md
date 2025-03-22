## Game Engine
- **Odpowiedzialności**:
    - obsługa rozgrywki
    - poruszanie się po mapie
    - inicjowanie walki
- **Współpracownicy**:
    - Map
    - Player
    - Fight

## Map
- **Odpowiedzialności**:
    - przechowywanie pozycji postaci
- **Współpracownicy**:
    - Player

## Player
- **Odpowiedzialności**:
    - posiadanie ekwipunku (broni, zbroi, tarczy)
    - posiadanie doświadczenia, siły, punktów zdrowia, many
- **Współpracownicy**:
    - Fight
    - Item

## Fight
- **Odpowiedzialności**:
    - zarządzanie przebiegiem tur
    - obliczanie zadanych obrażeń
    - aktualizowanie poziomu doświadczenia
    - rozstrzyganie walki
- **Współpracownicy**:
    - Player
    - Weapon
    - Armor
    - Shield
    - Magic

## Item
- **Odpowiedzialności**:
    - przechowywanie statystyk i typu przedmiotu
- **Współpracownicy**:
    - Weapon
    - Armor
    - Shield

## Weapon
- **Odpowiedzialności**:
    - posiadanie wartości zadawanych obrażeń
- **Współpracownicy**:

## Armor
- **Odpowiedzialności**:
    - posiadanie wartości redukowanych obrażeń
- **Współpracownicy**:

## Shield
- **Odpowiedzialności**:
    - posiadanie wartości blokowanych obrażeń
- **Współpracownicy**:

## Magic
- **Odpowiedzialności**:
    - przechowywanie możliwych czarów
    - losowanie czaru
    - uzależnianie dostępności czarów na podstawie poziomu many
- **Współpracownicy**: