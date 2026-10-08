# portfolio-android

A modern portfolio app for Toxic Sabbir, converted to an Expo app compatible with EAS Build.

## EAS build setup
This project is ready for Expo Application Services (EAS) builds.

### 1. Install dependencies
```bash
npm install
```

### 2. Log in to EAS
```bash
npx eas login
```

### 3. Configure EAS project
```bash
npx eas build:configure
```

### 4. Build APK for Android
```bash
npx eas build --platform android --profile preview
```

This can generate an APK that can be downloaded and installed directly on your Android phone.

## Run locally
```bash
npx expo start
```

## Repository
https://github.com/Toxic-Sabbir/portfolio-android
