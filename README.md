# CCMOSDK Light Version Tester
CCMOSDK Light Version 사용법을 알아보자.

## SDK 개발버전 및 요구사항
- compileSdk = 34
- minSdk = 24
- 설치하려는 앱이 최소 API 24 (Android 7.0) 이상일 경우에만 정상작동이 가능합니다. 

## 설치
### 1. SDK 임포트
- 앱수준의 build.gradle 의 dependencies 블럭내에 아래의 코드를 추가한다.
```
implementation("io.github.viplesoft:ccmosdk-light:0.9.10")
```

### 2. JitPack 설정
- settings.gradle 파일내에 아래의 코드를 추가한다.
```
dependencyResolutionManagement {
    ...
    repositories {
        ...
        maven { url = uri("https://www.jitpack.io") }
    }
}
```

### 3. AndroidManifest 설정
- 인터넷에 연결할 수 있는 권한이 필요합니다. 아래의 코드를 추가해주시고 이미 선언되어있다면 스킵하세요.
```
<uses-permission android:name="android.permission.INTERNET" />
```

### 4. gradle.properties 설정
- 이전 Support Library를 사용하는 라이브러리와의 호환을 위해 아래의 코드를 파일에 추가해주세요
```
android.enableJetifier=true
```
<paths>
    <external-path name="external" path="." />
    <external-cache-path name="external_cache" path="." />
</paths>
```

## SDK 사용
### 1. SDK 초기화

```
val ccmo = CCMO("발급받은 앱키", "앱에서 회원식별이 가능한 ID")
```

### 2. SDK 생성

```
ccmo.create(this)
```

위의 코드가 실행되면 SDK내의 UI 액티비티가 실행되면서 서비스가 시작됩니다. 
