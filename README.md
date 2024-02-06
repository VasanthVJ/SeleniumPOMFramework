# SeleniumPOMFramework

    projects: [
      { name: "setup", testMatch: /.*\.setup\.ts/ },
          {
            name: 'local',
            testMatch: '**/*.setup.ts/',
          },
          {
            name: 'Chrome Browser',
            use: { ...devices['Desktop Chrome'],
             channel: 'chrome' },
            dependencies: ['setup'],
        },
    ]
