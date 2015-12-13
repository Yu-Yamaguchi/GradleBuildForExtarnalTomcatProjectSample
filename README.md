Gradleを使って外部プロジェクトのビルド・テストを実行するサンプル
====

##Overview
様々な大人の事情により、JavaによるWebアプリケーション開発を、Eclipseの**「Tomcatプロジェクト」**で開発しなければならないとしましょう。
Gradleプロジェクトにはしちゃいけないんです。

そこで、もう1つGradleのプロジェクトを作成し、大人の事情で作ったTomcatプロジェクトを外部参照して、Gradleからテストを実行したり、Findbugsを動かしたりできないかなぁと考えてみました。

そのサンプルです。

## Description

プロジェクトの構成は以下のディレクトリ構成とします。
GradleBuildForExtarnalTomcatProjectSample/
　├ **TomcatProject/**　…Tomcatプロジェクト（プロダクト）
　│    ├ WEB-INF
　│    │    ├src  …Tomcat標準のJavaソースが格納されるディレクトリ
　│    │    ├resources　…リソース格納用
　│    │    ├test/java　…テストソース格納用
　│    │    └test/resources　…テストリソース格納用
　│    ├ build.gradle　…Tomcatプロジェクトにbuild.gradleファイルだけ追加させてもらう。
　│    └その他省略
　│
　└ **TomcatProjectGradle/**　…上記Tomcatプロジェクトに対しGradleからビルドなどをかける呼び出し元プロジェクト
　　    ├settings.gradle　…上記「TomcatProject」を参照するために必要な設定ファイル
　　    └その他省略

> **おそらく**

> - TomcatProject内部にテストコードを書かずに、TomcatProjectGradle側にテストコードを記述することができたかもしれない。（今回のケースでは、テストコードをTomcatProject内に作成することが制約上OKだったので上記構成となっている。）

## Usage

- コマンドプロンプトからカレントディレクトリをTomcatProjectGradleに変更。
- 以下のコマンドを実行
	`gradlew testAllTests`
 
 これだけです。
 TomcatProjectにはbuildディレクトリなど生成されず、TomcatProjectGradle内にbuildディレクトリが生成され、JUnitやFindbugsのレポートが出力されていると思います。


## Author
[Yu-Yamaguchi](https://github.com/Yu-Yamaguchi)