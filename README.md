# 💰 RoundWise

**RoundWise** is an offline-first Android app for personal finance management with automatic savings via intelligent rounding.

Built with **Kotlin**, **Jetpack Compose**, and **Clean Architecture**.

---

## 🏗️ Architecture

```
:app  ──▶  :ui  ──▶  :domain  (pure Kotlin — no Android deps)
            │              ▲
            ▼              │
          :core  ──▶  :data  (Room + Hilt)
```

| Module | Responsibility |
|--------|---------------|
| `:domain` | Business models, Repository interfaces, UseCases (pure Kotlin) |
| `:data` | Room entities, DAOs, Repository implementations |
| `:core` | Hilt DI module, CSV parser utility |
| `:ui` | Compose screens, ViewModels, Navigation |
| `:app` | Android entry point (MainActivity, Application) |

---

## 🚀 Build & Run

**Requirements:** Android Studio Hedgehog+, API 26+ device/emulator

```bash
git clone https://github.com/AmmarHamdi/roundwise.git
cd roundwise
./gradlew assembleDebug
```

Or open in Android Studio and click **Run ▶**.

---

## 📱 Screens

1. **Onboarding** — Welcome screen, loads 20 demo transactions + default rounding rules
2. **Dashboard** — Total savings summary, portfolio simulation curve (Canvas), savings goals with progress bars
3. **Transactions** — Full transaction list with rounded amounts; CSV import via file picker

---

## 📥 CSV Import

Tap the **upload icon** on the Transactions screen to import a CSV file.

**Expected format:**
```
date,label,amount,category
2024-01-15,Supermarché,-45.30,Alimentation
2024-01-20,Salaire,2850.00,Revenu
```

Supported date formats: `YYYY-MM-DD`, `DD/MM/YYYY`, `MM-DD-YYYY`

A sample file is available at `app/src/main/assets/demo_transactions.csv`.

---

## 🔄 Rounding Strategies

| Strategy | Description | Example (2.30€) |
|----------|-------------|-----------------|
| `UP_TO_NEXT` | Round up to nearest step | → 3.00€ (save 0.70€) |
| `NEAREST` | Round to nearest step | → 2.00€ |
| `FIXED_PERCENT` | Save a fixed % of each expense | 5% → save 0.12€ |
| `CUSTOM_STEP` | Round up to custom step (e.g. 0.50€) | → 2.50€ (save 0.20€) |

---

## 📊 Portfolio Simulation

The Dashboard displays a projected savings curve over 12 months, based on the average monthly savings computed from your transaction history.

---

## 🛠️ Tech Stack

- **Language:** Kotlin 1.9
- **UI:** Jetpack Compose + Material 3
- **Database:** Room 2.6
- **DI:** Hilt 2.51
- **Navigation:** Navigation Compose 2.7
- **Async:** Kotlin Coroutines + Flow
- **Architecture:** Clean Architecture (domain / data / core / ui / app)